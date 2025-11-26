package citedocs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import citedocs.Entity.NotificationEntity;
import citedocs.Service.NotificationService;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    NotificationService nserv;

    @PostMapping("/postNotification")
    public NotificationEntity postNotification(@RequestBody NotificationEntity n) {
        return nserv.postNotification(n);
    }

    @GetMapping("/getAllNotifications")
    public List<NotificationEntity> getAllNotifications() {
        return nserv.getAllNotifications();
    }

    @PutMapping("/updateNotification")
    public NotificationEntity updateNotification(@RequestParam int id, @RequestBody NotificationEntity newNotifDetails) {
        return nserv.updateNotification(id, newNotifDetails);
    }

    @DeleteMapping("/deleteNotification/{id}")
    public String deleteNotification(@PathVariable int id) {
        return nserv.deleteNotification(id);
    }
}
