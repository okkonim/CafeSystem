package cafeSystem.serviceImpl;

import cafeSystem.constents.CafeConstants;
import com.google.common.base.Strings;
import cafeSystem.dao.CategoryDao;
import cafeSystem.jwt.JwtFilter;
import cafeSystem.pojo.Category;
import cafeSystem.service.CategoryService;
import cafeSystem.utils.CafeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;
    private final JwtFilter jwtFilter;
    @Override
    public ResponseEntity<String> addCategory(Map<String, String> requestMap) {
        try {
            if(jwtFilter.isAdmin()){
                if(this.validateCategoryMap(requestMap, false)){
                    categoryDao.save(getCategoryFromMap(requestMap, false));
                    return CafeUtils.getResponseEntity("Category was added successfully", HttpStatus.OK);
                }
            }else {
                return CafeUtils.getResponseEntity(CafeConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception exception){
            log.error("Error in addCategory", exception);
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Category>> getCategories(String filterValue) {
        try {
            if(!Strings.isNullOrEmpty(filterValue) && filterValue.equalsIgnoreCase(CafeConstants.STATUS_TRUE))
                return new ResponseEntity<>(categoryDao.getAllCategory(), HttpStatus.OK);
            return new ResponseEntity<>(categoryDao.findAll(), HttpStatus.OK);
        } catch (Exception exception){
            log.error("Error in getCategories", exception);
        }
        return new ResponseEntity<List<Category>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateCategory(Map<String, String> requestMap) {
        try {
            if(jwtFilter.isAdmin()){
                if(validateCategoryMap(requestMap, true)){
                    Optional<Category> category = categoryDao.findById(Integer.parseInt(requestMap.get("id")));
                    if(!category.isEmpty()){
                        categoryDao.save(this.getCategoryFromMap(requestMap, true));
                        return CafeUtils.getResponseEntity("Category was updated successfully", HttpStatus.OK);
                    } else {
                        return CafeUtils.getResponseEntity("Category with id "+Integer.parseInt(requestMap.get("id")) +" does not exists" ,HttpStatus.BAD_REQUEST);
                    }
                }
                return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
            return CafeUtils.getResponseEntity(CafeConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
        } catch (Exception exception){
            log.error("Error in updateCategory", exception);
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateCategoryMap(Map<String, String> requestMap, boolean validateId) {
        if(requestMap.containsKey("name")){
            if(requestMap.containsKey("id") && validateId){
                return true;
            }
            return !validateId;
        }
        return false;
    }
    private Category getCategoryFromMap(Map<String, String> requestMap, Boolean isAdd){
        Category category = new Category();
        if(isAdd){
            category.setId(Integer.parseInt(requestMap.get("id")));
        }
        category.setName(requestMap.get("name"));
        return category;
    }

}
