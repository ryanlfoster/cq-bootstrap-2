/*global ecommerce: true */

<%@ page contentType="text/javascript;charset=UTF-8" language="java" %>

<%@ taglib prefix="ecomm" uri="http://www.smithstone.com/ecommerce/tags" %>


        (function (ecomm) {
            'use strict';
            ecomm.products = {

                <ecomm:productsToJsonTag/>
                data: ${productsData}

            };
        })(ecommerce);
