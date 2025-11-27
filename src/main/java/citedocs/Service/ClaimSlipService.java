package citedocs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citedocs.Entity.ClaimSlipEntity;
import citedocs.Repository.ClaimSlipRepository;

@Service
public class ClaimSlipService {

    @Autowired
    private ClaimSlipRepository crepo;

    public ClaimSlipService(ClaimSlipRepository crepo) {
        this.crepo = crepo;
    }

    // C
    public ClaimSlipEntity postClaimSlip(ClaimSlipEntity claimSlip) {
        return crepo.save(claimSlip);
    }

    // R
    public List<ClaimSlipEntity> getAllClaimSlips() {
        return crepo.findAll();
    }

    // U
    @SuppressWarnings("finally")
    public ClaimSlipEntity updateClaimSlip(int cid, ClaimSlipEntity newDetails) {
        ClaimSlipEntity claimSlip = new ClaimSlipEntity();

        try {
            claimSlip = crepo.findById(cid)
                .orElseThrow(() -> new NoSuchElementException("Claim Slip " + cid + " does not exist!"));

            claimSlip.setClaimNumber(newDetails.getClaimNumber());
            claimSlip.setDateReady(newDetails.getDateReady());
            claimSlip.setIssuedAt(newDetails.getIssuedAt());

        } catch (NoSuchElementException e) {
            throw e;
        } finally {
            return crepo.save(claimSlip);
        }
    }

    // D
    public String deleteClaimSlip(int cid) {
        if (crepo.existsById(cid)) {
            crepo.deleteById(cid);
            return "Claim Slip " + cid + " is successfully deleted!";
        } else {
            return "Claim Slip " + cid + " does not exist!";
        }
    }
}
