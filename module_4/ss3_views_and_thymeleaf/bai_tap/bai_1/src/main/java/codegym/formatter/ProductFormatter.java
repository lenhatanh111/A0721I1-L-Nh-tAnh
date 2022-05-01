package codegym.formatter;

import codegym.entity.Product;
import codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ProductFormatter implements Formatter<Product> {
    @Autowired
    private IProductService service;
    @Autowired
    public ProductFormatter(IProductService service){
        this.service=service;
    }
    @Override
    public Product parse(String text, Locale locale) throws ParseException {
        return service.findById(text);
    }

    @Override
    public String print(Product object, Locale locale) {
        return object.toString();
    }
}
