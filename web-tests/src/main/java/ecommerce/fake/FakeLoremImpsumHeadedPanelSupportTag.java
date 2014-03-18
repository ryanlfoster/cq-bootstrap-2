package ecommerce.fake;

import ecommerce.domain.HeadedPanelModel;
import ecommerce.web.tags.AbstractHeadedPanelSupportTag;
import ecommerce.web.tags.HeadedPanelModelFactory;

public class FakeLoremImpsumHeadedPanelSupportTag extends AbstractHeadedPanelSupportTag {

    @Override
    protected HeadedPanelModelFactory getModelFactory() {
        return new HeadedPanelModelFactory() {
            @Override
            public HeadedPanelModel getInstance() {
                return new HeadedPanelModel() {
                    @Override
                    public String getHeaderText() {
                        return "Fake Header Text";
                    }

                    @Override
                    public String getText() {
                        String s = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        s += "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur cumque delectus dolores laborum maxime minus odio pariatur perspiciatis voluptate. At error iure necessitatibus nisi nulla, placeat qui ratione ullam vero.\n";
                        return s;
                    }
                };
            }
        };
    }
}


