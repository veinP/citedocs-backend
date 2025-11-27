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

import citedocs.Entity.ClaimSlipEntity;
import citedocs.Service.ClaimSlipService;

@RestController
@RequestMapping("/claimslips")
public class ClaimSlipController {

    @Autowired
    private ClaimSlipService cserv;

    // C
    @PostMapping("/postClaimSlip")
    public ClaimSlipEntity postClaimSlip(@RequestBody ClaimSlipEntity claimSlip) {
        return cserv.postClaimSlip(claimSlip);
    }

    // R
    @GetMapping("/getAllClaimSlips")
    public List<ClaimSlipEntity> getAllClaimSlips() {
        return cserv.getAllClaimSlips();
    }

    // U
    @PutMapping("/updateClaimSlip")
    public ClaimSlipEntity updateClaimSlip(@RequestParam int cid, @RequestBody ClaimSlipEntity newDetails) {
        return cserv.updateClaimSlip(cid, newDetails);
    }

    // D
    @DeleteMapping("/deleteClaimSlip/{cid}")
    public String deleteClaimSlip(@PathVariable int cid) {
        return cserv.deleteClaimSlip(cid);
    }
}
