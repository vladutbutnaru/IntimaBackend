package ro.enered.entities;

import java.io.InputStream;

/**
 * Created by macbook on 25/12/2016.
 */
public class FileMeta {

    private String fileName;
    private String fileSize;
    private String fileType;
    private String twitter;

    private InputStream content;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public InputStream getContent() {
        return content;
    }

    public void setContent(InputStream content) {
        this.content = content;
    }
}
