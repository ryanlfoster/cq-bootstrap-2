package ecommerce.web.tags;

import org.codehaus.jackson.JsonGenerator;

class StaticProductGenerator {

    public void generateProduct(JsonGenerator generator, final int sku) {
        ProductJsonGenerator.writeJson(generator, new Product() {
            @Override
            public String getName() {
                return "Product Information #";
            }

            @Override
            public String getDescription() {
                return getLoremIpsum();
            }

            @Override
            public String getImageSource() {
                return "//placekitten.com/340/300";
            }

            @Override
            public int getQuantity() {
                return 0;
            }

            @Override
            public String getCode() {
                return String.valueOf(sku);
            }
        });
    }


    private String getLoremIpsum() {
        return "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque modi, vel? Amet assumenda consequatur cum dolore, explicabo, inventore iste iusto magni minima mollitia omnis pariatur quae sequi soluta unde voluptas!";
    }
}
