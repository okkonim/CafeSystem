package cafeSystem.restImpl;

import cafeSystem.constents.CafeConstants;
import cafeSystem.service.CategoryService;
import cafeSystem.pojo.Category;
import cafeSystem.rest.CategoryRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryRestImpl implements CategoryRest {
    private final CategoryService categoryService;
    @Override
    public ResponseEntity<String> addCategory(Map<String, String> requestMap) {
        try {
            return categoryService.addCategory(requestMap);
        } catch (Exception exception){
            log.error("Error in addCategory", exception);
            return new ResponseEntity<>(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Category>> getCategories(String filterValue) {
        try {
            return categoryService.getCategories(filterValue);
        } catch (Exception exception){
            log.error("Error in getCategories", exception);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateCategory(Map<String, String> requestMap) {
        try {
            return categoryService.updateCategory(requestMap);
        } catch (Exception exception){
            log.error("Error in updateCategory", exception);
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
