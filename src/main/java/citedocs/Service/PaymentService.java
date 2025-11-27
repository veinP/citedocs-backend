package citedocs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citedocs.Entity.PaymentEntity;
import citedocs.Repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository prepo;

    public PaymentService(PaymentRepository prepo){
        this.prepo = prepo;
    }

    // C
    public PaymentEntity postPayment(PaymentEntity payment) {
        return prepo.save(payment);
    }

    // R
    public List<PaymentEntity> getAllPayments() {
        return prepo.findAll();
    }

    // U
    @SuppressWarnings("finally")
    public PaymentEntity updatePayment(int pid, PaymentEntity newDetails) {
        PaymentEntity payment = new PaymentEntity();

        try {
            payment = prepo.findById(pid)
                .orElseThrow(() -> new NoSuchElementException("Payment " + pid + " does not exist!"));

            payment.setRid(newDetails.getRid());
            payment.setProofOfPayment(newDetails.getProofOfPayment());
            payment.setRemarks(newDetails.getRemarks());

        } catch (NoSuchElementException e) {
            throw e;
        } finally {
            return prepo.save(payment);
        }
    }
    // D
    public String deletePayment(int pid) {
        if (prepo.existsById(pid)) {
            prepo.deleteById(pid);
            return "Payment " + pid + " is successfully deleted!";
        } else {
            return "Payment " + pid + " does not exist!";
        }
    }
}
