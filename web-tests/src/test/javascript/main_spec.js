'use strict';

describe("main" , function(){

    beforeEach(function(){
        $.ajaxSetup({
            async : false
        });
        $.get('http://localhost:9999/web-tests/fixtures/product-test.jsp', function(data) {
            setFixtures(data);
        });

    });

    it("should be able to run tests", function () {
        expect(a()).toBeTruthy();
        expect($(".product-info").size()).toBe(1);
    });

});
