package citedocs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citedocs.Entity.NotificationEntity;
import citedocs.Repository.NotificationRepository;

@SuppressWarnings("null")
@Service
public class NotificationService {

    @Autowired
    NotificationRepository nrepo;

    public NotificationEntity postNotification(NotificationEntity n) {
        return nrepo.save(n);
    }

    public List<NotificationEntity> getAllNotifications() {
        return nrepo.findAll();
    }

    @SuppressWarnings("finally")
    public NotificationEntity updateNotification(int id, NotificationEntity newNotifDetails) {
        NotificationEntity notif = new NotificationEntity();

        try {
            notif = nrepo.findById(id).get();

            notif.setUserId(newNotifDetails.getUserId());
            notif.setRequestId(newNotifDetails.getRequestId());
            notif.setMessage(newNotifDetails.getMessage());
            notif.setIsRead(newNotifDetails.getIsRead());
            notif.setCreatedAt(newNotifDetails.getCreatedAt());

        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException("Notification " + id + " does not exist.");
        } finally {
            return nrepo.save(notif);
        }
    }

    public String deleteNotification(int id) {
        String msg = "";
        if (nrepo.findById(id).isPresent()) {
            nrepo.deleteById(id);
            msg = "Notification " + id + " is successfully deleted!";
        } else {
            msg = "Notification " + id + " does not exist.";
        }
        return msg;
    }
}

