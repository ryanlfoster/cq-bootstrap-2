package ecommerce.web.tags;

public interface NavBarFactory {

    NavBarHeaderUIFactory getHeaderFactory();

    NavBarBodyModelUIFactory getBodyFactory();

}
