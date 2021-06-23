package formatter;

import model.Category;
//import model.Province;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.category.ICategoryService;
//import service.province.IProvinceService;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category> {

    private ICategoryService service;

    public CategoryFormatter() {
    }

    public CategoryFormatter(ICategoryService service){
        this.service = service;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Category category = service.findById(Long.parseLong(text));
        return category;
    }

    @Override
    public String print(Category object, Locale locale) {
        return null;
    }
}