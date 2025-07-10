package cafeSystem.restImpl;

import cafeSystem.constents.CafeConstants;
import cafeSystem.rest.BillRest;
import cafeSystem.service.BillService;
import cafeSystem.pojo.Bill;
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
public class BillRestImpl implements BillRest {
    private final BillService billService;
    @Override
    public ResponseEntity<String> generateReport(Map<String, Object> requestMap) {
        try {
            return billService.generateReport(requestMap);
        } catch (Exception exception){
            log.error("Error in generateReport", exception);
            return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Bill>> getBills() {
        try {
            return billService.getBills();
        } catch (Exception exception){
            log.error("Error in getBills", exception);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<byte[]> getPdf(Map<String, Object> requestMap) {
        try {
            return billService.getPdf(requestMap);
        } catch (Exception exception){
            log.error("Error in getPdf", exception);
        }
        return new ResponseEntity<>(new byte[0],HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteBill(Integer id) {
        try {
            return billService.deleteBill(id);
        } catch (Exception exception){
            log.error("Error in deleteBill", exception);
        }
        return new ResponseEntity<>(("{\"message\":\"" + CafeConstants.SOMETHING_WENT_WRONG + "\"}"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
