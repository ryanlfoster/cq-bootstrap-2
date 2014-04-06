

<link rel="stylesheet" href="/etc/designs/ecommerce/style/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/etc/designs/ecommerce/style/bootstrap/css/bootstrap-theme.css"/>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/etc/designs/ecommerce/style/bootstrap/js/bootstrap.js"></script>
<script src="/etc/designs/ecommerce/javascript/deps/angular.js"></script>

<script src="/etc/designs/ecommerce/javascript/main.js"></script>


<script>
    (function (ecomm) {
        'use strict';
        ecomm.products = {

            data: [
                {
                    sku : 0,
                    name: "Product Information #1",
                    description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda " +
                            "consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur" +
                            "quae sequi soluta unde voluptas!",
                    image: "//placekitten.com/340/300",
                    cost : parseFloat(Math.random() * 200).toFixed(2)
                },
                {
                    sku : 1,
                    name: "Product Information #2",
                    description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda " +
                            "consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur" +
                            "quae sequi soluta unde voluptas!",
                    image: "//placekitten.com/340/300",
                    cost : parseFloat(Math.random() * 200).toFixed(2)
                },
                {
                    sku : 2,
                    name: "Product Information #3",
                    description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda " +
                            "consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur" +
                            "quae sequi soluta unde voluptas!",
                    image: "//placekitten.com/340/300",
                    cost : parseFloat(Math.random() * 200).toFixed(2)
                },
                {
                    sku : 3,
                    name: "Product Information #4",
                    description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda " +
                            "consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur" +
                            "quae sequi soluta unde voluptas!",
                    image: "//placekitten.com/340/300",
                    cost : parseFloat(Math.random() * 200).toFixed(2)
                },
                {
                    sku: 4,
                    name: "Product Information #5",
                    description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda " +
                            "consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur" +
                            "quae sequi soluta unde voluptas!",
                    image: "//placekitten.com/340/300",
                    cost : parseFloat(Math.random() * 200).toFixed(2)
                },
                {
                    sku : 5,
                    name: "Product Information #6",
                    description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda " +
                            "consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur" +
                            "quae sequi soluta unde voluptas!",
                    image: "//placekitten.com/340/300",
                    cost : parseFloat(Math.random() * 200).toFixed(2)
                }
            ]

        };
    })(ecommerce);
</script>

<script src="/etc/designs/ecommerce/javascript/lib/controllers/cart_controller.js"></script>
<script src="/etc/designs/ecommerce/javascript/lib/controllers/product_controller.js"></script>


<script src="/etc/designs/ecommerce/javascript/lib/directives/cart-button.js"></script>
<script src="/etc/designs/ecommerce/javascript/lib/directives/productTile.js"></script>
<script src="/etc/designs/ecommerce/javascript/lib/directives/product_information_button.js"></script>
<script src="/etc/designs/ecommerce/javascript/lib/directives/headedpanel.js"></script>
<script src="/etc/designs/ecommerce/javascript/lib/directives/panel.js"></script>

<script src="/etc/designs/ecommerce/javascript/lib/services/cart_service.js"></script>


<meta name="viewport" content="width=device-width, initial-scale=1">
