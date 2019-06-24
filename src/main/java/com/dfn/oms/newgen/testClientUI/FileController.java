package com.dfn.oms.newgen.testClientUI;

import com.dfn.oms.newgen.testClientUI.bean.FileService;
import com.dfn.oms.newgen.testClientUI.bean.JMSSender;
import com.dfn.oms.newgen.testClientUI.bean.WebSocketRunner;
import com.dfn.oms.newgen.testClientUI.bean.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
@RestController
public class FileController {
    private final FileService fileService;
    private static StringBuilder stringBuilder;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }



    @PostMapping(value = "/api/files")
    @ResponseStatus(HttpStatus.OK)
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        WebSocketRunner webSocketRunner = new WebSocketRunner();
        webSocketRunner.TEXT_PATH = file.getOriginalFilename();
        webSocketRunner.operatingMethod = true;
        System.out.println(file.getOriginalFilename());
        fileService.storeFile(file);
    }

    @PostMapping(value = "/api/files/jms")
    @ResponseStatus(HttpStatus.OK)
    public void handleFileUploadJms(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println(file.getOriginalFilename());
        fileService.storeFileJms(file);
        String line = null;
        JMSSender jmsSender = new JMSSender();
        jmsSender.createConnection();
        stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            System.out.println(stringBuilder.toString());
            sendMessage(jmsSender,stringBuilder.toString());
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '" + fileName + "'");

        }
    }

    public JMSSender createMiddlewareConnection(){
        JMSSender jmsSender = new JMSSender();
        jmsSender.createConnection();
        return jmsSender;
    }
    public void sendMessage(JMSSender jmsSender, String message){
        jmsSender.sendMessage("23041", Settings.SID, message);
    }

}
