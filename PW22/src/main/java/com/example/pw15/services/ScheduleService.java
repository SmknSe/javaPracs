package com.example.pw15.services;

import com.example.pw15.manufactures.Manufacture;
import com.example.pw15.phones.Phone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;

@Service
@Slf4j
@ManagedResource(description = "Schedule service bean")
public class ScheduleService {

    @Autowired
    private PhoneService phoneService;
    @Autowired
    private ManufactureService manufactureService;

    private final String BACKUP_DIR = "src/backups/";

    @Scheduled(cron = "0 * * * * *")
    @ManagedOperation(description = "remaking backup")
    public void backup() throws IOException {
        log.info("Scheduled task");
        File file_dir = new File(BACKUP_DIR);
        try {
            for (File file : file_dir.listFiles())
                if (file.isFile()) {
                    file.delete();
                    log.info(file.getName() +" is deleted");
                }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        log.info("Files deleted");
        BufferedWriter manufactures = new BufferedWriter(new FileWriter(BACKUP_DIR + "manufactures.txt"));
        BufferedWriter phones = new BufferedWriter(new FileWriter(BACKUP_DIR + "phones.txt"));

        for (Manufacture item : manufactureService.findAll()) {
            manufactures.write(item.toString());
            manufactures.write('\n');
        }
        manufactures.close();

        for (Phone item : phoneService.findAll()) {
            phones.write(item.toString());
            phones.write('\n');
        }
        phones.close();
        log.info("Sheduled Task is ended");
    }
}
