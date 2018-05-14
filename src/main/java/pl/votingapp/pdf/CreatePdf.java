package pl.votingapp.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import pl.votingapp.dto.VotingDto;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CreatePdf {

    public byte[] getDocument(VotingDto voting) throws IOException, DocumentException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BaseFont bf = BaseFont.createFont("Helvetica", "ISO-8859-2", false);

        Document document = new Document(PageSize.A4, 15, 15, 15, 15);
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        document.add(new Paragraph("Lublin - "+voting.getDate(), new Font(bf)));
        document.add(new Paragraph("                            ", new Font(bf)));
        document.add(new Paragraph("Wspólnota mieszkaniowa  - "+voting.getAdres(), new Font(bf)));
        document.add(new Paragraph("Numer uchwały: "+voting.getResolution(), new Font(bf)));
        document.add(new Paragraph("                            ", new Font(bf)));
        document.add(new Paragraph("Tytuł uchwały: "+voting.getTitle(), new Font(bf)));
        document.add(new Paragraph("                            ", new Font(bf)));
        document.add(new Paragraph("Treść uchwały: ", new Font(bf)));
        document.add(new Paragraph(voting.getContent(), new Font(bf)));
        document.add(new Paragraph("                            ", new Font(bf)));
        document.add(new Paragraph("                            ", new Font(bf)));
        document.add(new Paragraph("---------------------------------------", new Font(bf)));
        document.add(new Paragraph("Głosowało za: "+(String.format("%.0f%%",voting.getVotesFor()*100)), new Font(bf)));
        document.add(new Paragraph("Głosowało przeciw: "+(String.format("%.0f%%",voting.getVotesAgainst()*100)), new Font(bf)));
        document.add(new Paragraph("Wstrzymało się od głosu: "+(String.format("%.0f%%",voting.getVotesAbstain()*100)), new Font(bf)));
        document.add(new Paragraph("---------------------------------------", new Font(bf)));
        document.add(new Paragraph("                            ", new Font(bf)));
        document.add(new Paragraph("                            ", new Font(bf)));
        document.add(new Paragraph("                            ", new Font(bf)));
                document.add(new Paragraph("Przewodniczący zebrania: "+voting.getModerator()
                +"          Sekretarz: "+voting.getSecretary(), new Font(bf)));
        document.close();
        byte[] pdfBytes = byteArrayOutputStream.toByteArray();

        return pdfBytes;
    }
}
