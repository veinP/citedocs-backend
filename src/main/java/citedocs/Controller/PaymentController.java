package citedocs.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import citedocs.Entity.PaymentEntity;
import citedocs.Service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentEntity create(@RequestBody PaymentEntity payload) {
        return paymentService.create(payload);
    }

    @GetMapping
    public List<PaymentEntity> findAll() {
        return paymentService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentEntity findById(@PathVariable int id) {
        return paymentService.findById(id);
    }

    @PutMapping("/{id}")
    public PaymentEntity update(@PathVariable int id, @RequestBody PaymentEntity payload) {
        return paymentService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        paymentService.delete(id);
    }
}

