package citedocs.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import citedocs.Entity.PaymentEntity;
import citedocs.Service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService pserv;

    //C
    @PostMapping("/postPayment")
    public PaymentEntity postPayment(@RequestBody PaymentEntity payment) {
        return pserv.postPayment(payment);
    }

    //R
    @GetMapping("/getAllPayments")
    public List<PaymentEntity> getAllPayments() {
        return pserv.getAllPayments();
    }

    //U
    @PutMapping("/updatePayment")
    public PaymentEntity updatePayment(@RequestParam int pid, @RequestBody PaymentEntity newPaymentDetails) {
        return pserv.updatePayment(pid, newPaymentDetails);
    }

    //D
    @DeleteMapping("/deletePayment/{pid}")
    public String deletePayment(@PathVariable int pid) {
        return pserv.deletePayment(pid);
    }
}
