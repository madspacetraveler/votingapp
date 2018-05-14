package pl.votingapp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.votingapp.bo.VotingService;
import pl.votingapp.pdf.CreatePdf;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PdfController {

    private final VotingService votingService;

    @GetMapping(value = "/votings/generatepdf/{votingId}")
    public ResponseEntity<byte[]> getDownloadData(@PathVariable("votingId") Long votingId) throws Exception {

        byte[] documentpdf = new CreatePdf().getDocument(votingService.findVotingById(votingId));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charset", "utf-8");
        responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
        responseHeaders.setContentLength(documentpdf.length);
        responseHeaders.set("Content-disposition", "attachment; filename=uchwala_numer_"+votingId+".pdf");

        return new ResponseEntity<byte[]>(documentpdf, responseHeaders, HttpStatus.OK);
    }
}
