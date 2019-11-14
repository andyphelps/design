package uk.gov.ukho.dpworkshops.two.services;

public class UploadService {
  public static Boolean uploadData(int id, String content) {
    System.out.println("Stored id " + id + " with content '" + content + "'");
    return true;
  }
}
