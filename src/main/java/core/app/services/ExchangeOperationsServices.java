package core.app.services;

import core.app.entity.BuyingCurrency;
import core.app.entity.CursValutar;
import core.app.entity.DetailedNumerar;
import core.app.entity.Operator;

public interface ExchangeOperationsServices {

    boolean serviceAddExchangeRate(CursValutar currencyVal);

    boolean serviceBuyingCurrency(BuyingCurrency buyingCurrency);

    CursValutar serviceGetExchangeRate(String currencyId);

    boolean serviceEditExchangeRate(DetailedNumerar numerar);

    boolean addOperatorInSystem(Operator operator);

}
