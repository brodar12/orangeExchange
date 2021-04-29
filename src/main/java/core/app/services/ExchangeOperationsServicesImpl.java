package core.app.services;

import core.app.entity.*;
import core.app.repository.CurrencyRepository;
import core.app.repository.NumerarRepository;
import core.app.repository.OperatorRepository;
import core.app.repository.SchimbValutarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ExchangeOperationsServicesImpl implements ExchangeOperationsServices {

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    OperatorRepository operatorRepository;

    @Autowired
    NumerarRepository numerarRepository;

    @Autowired
    SchimbValutarRepository schimbValutarRepository;

    @Override
    public boolean serviceAddExchangeRate(CursValutar currencyVal) {

        Optional<CursValutar> cursValutar = Optional.ofNullable(currencyRepository.findPerCursValutar(currencyVal.getCodValuta()));

        if (cursValutar.isPresent()) {
            return false;
        } else {
            currencyVal.setDataAdaugare(LocalDateTime.now());
            currencyRepository.save(currencyVal);
        }

        return true;
    }

    @Override
    public boolean serviceBuyingCurrency(BuyingCurrency buyingCurrency) {

        Optional<CursValutar> cursValutar = Optional.ofNullable(currencyRepository.findPerCursValutar(buyingCurrency.getCurrencyId()));
        Optional<Operator> operator = Optional.ofNullable(operatorRepository.findOperatorPerUsername(buyingCurrency.getOperatorId()));

        if (cursValutar.isPresent() && operator.isPresent()) {
            schimbValutarRepository.save(SchimbValutar.builder()
                    .cursValutar((int) cursValutar.get().getId())
                    .operator((int) operator.get().getId())
                    .dataEfectuareOperatiune(LocalDateTime.now())
                    .sumaPrimita(buyingCurrency.getReceivedAmount())
                    .sumaEliberata((int) (buyingCurrency.getReceivedAmount() * cursValutar.get().getCurs()))
                    .build());
        } else {
            return false;
        }

        return true;
    }

    @Override
    public CursValutar serviceGetExchangeRate(String currencyId) {
        return currencyRepository.findPerCursValutar(currencyId);
    }

    @Override
    public boolean serviceEditExchangeRate(DetailedNumerar detailedNumerar) {
        Optional<CursValutar> cursValutar = Optional.ofNullable(currencyRepository.findPerCursValutar(detailedNumerar.getCodValuta()));
        Optional<Operator> operator = Optional.ofNullable(operatorRepository.findOperatorPerUsername(detailedNumerar.getUtilizator()));

        if (cursValutar.isPresent() && operator.isPresent()) {
            Numerar numerarSave = numerarRepository.findNumerarPerCodValuta(cursValutar.get(), operator.get());
            numerarSave.setSumaDisponibila(detailedNumerar.getSuma());
            numerarRepository.save(numerarSave);
        } else {
            return false;
        }

        return true;
    }

    @Override
    public boolean addOperatorInSystem(Operator operator) {

        operatorRepository.save(core.app.entity.Operator.builder()
                .username(operator.getUsername())
                .nume(operator.getNume())
                .prenume(operator.getPrenume())
                .build());

        return true;
    }

}
