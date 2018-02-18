package pl.mb2k15;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Matt on 2015-10-04.
 */
@Controller
public class FileController {

    @RequestMapping("/photo")
    public ResponseEntity<byte[]> testphoto(@RequestParam("name") String attributeparameter) throws IOException {
        File file = new File("C:/photos/", attributeparameter);
        byte[] bytes = FileUtils.readFileToByteArray(file);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.CREATED);

    }



}
