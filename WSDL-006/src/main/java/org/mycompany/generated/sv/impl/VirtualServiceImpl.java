package org.mycompany.generated.sv.impl;

import financials.CurrencyExchangeRequestType;
import financials.CurrencyExchangeResponseType;
import financials.CompanyDetailsRequestType;
import financials.CompanyDetailsAttrResponseType;
import financials.CompanyDetailsRequestType;
import financials.CompanyDetailsResponseType;
import financials.GetStockQuoteRequestType;
import financials.GetStockQuoteResponseType;
import com.ostiasolutions.api.datagen.ResponseUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VirtualServiceImpl
{
    public CurrencyExchangeResponseType CurrencyExchange(HttpServletRequest req, HttpServletResponse resp , CurrencyExchangeRequestType reqData)
    {
        return (CurrencyExchangeResponseType)ResponseUtils.responseFromXml(reqData, CurrencyExchangeResponseType.class);
    }

    public CompanyDetailsAttrResponseType GetCompanyInfoAttr(HttpServletRequest req, HttpServletResponse resp , CompanyDetailsRequestType reqData)
    {
        return (CompanyDetailsAttrResponseType)ResponseUtils.responseFromXml(reqData, CompanyDetailsAttrResponseType.class);
    }

    public CompanyDetailsResponseType GetCompanyInfoEle(HttpServletRequest req, HttpServletResponse resp , CompanyDetailsRequestType reqData)
    {
        return (CompanyDetailsResponseType)ResponseUtils.responseFromXml(reqData, CompanyDetailsResponseType.class);
    }

    public GetStockQuoteResponseType GetStockQuote(HttpServletRequest req, HttpServletResponse resp , GetStockQuoteRequestType reqData)
    {
        return (GetStockQuoteResponseType)ResponseUtils.responseFromXml(reqData, GetStockQuoteResponseType.class);
    }

}
