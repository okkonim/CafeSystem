package cafeSystem.restImpl;

import cafeSystem.constents.CafeConstants;
import cafeSystem.rest.ProductRest;
import cafeSystem.service.ProductService;
import cafeSystem.wrapper.ProductDTO;
import cafeSystem.wrapper.ProductWrapper;
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
public class ProductRestImpl implements ProductRest {
    private final ProductService productService;
    @Override
    public ResponseEntity<String> addProduct(ProductDTO productDTO) {
        try {
            Map<String, String> requestMap = new java.util.HashMap<>();
            requestMap.put("name", productDTO.getName());
            requestMap.put("categoryId", String.valueOf(productDTO.getCategoryId()));
            requestMap.put("description", productDTO.getDescription());
            requestMap.put("price", String.valueOf(productDTO.getPrice()));
            requestMap.put("image", productDTO.getImage());
            return productService.addProduct(requestMap);
        } catch (Exception exception){
            log.error("Error in addProduct", exception);
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<ProductWrapper>> getAllProducts() {
        try {
            return productService.getAllProducts();
        } catch (Exception exception){
            log.error("Error in getAllProducts", exception);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateProduct(Map<String, String> requestMap) {
        try {
            return productService.updateProduct(requestMap);
        } catch (Exception exception){
            log.error("Error in updateProduct", exception);
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteProduct(Integer id) {
        try {
            return productService.deleteProduct(id);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateStatus(Map<String, String> requestMap) {
        try {
            return productService.updateStatus(requestMap);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<ProductWrapper>> getByCategory(Integer id) {
        try {
            return productService.getByCategory(id);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<ProductWrapper> getById(Integer id) {
        try {
            return productService.getById(id);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ProductWrapper(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
