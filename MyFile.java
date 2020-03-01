import java.io.File;

class MyFile {
  private String fname1,fname2;
  private long fsize1=-1,fsize2=-1;

  public long getTotalSize() {
        long totalSize=-1;
        if (fsize1==-1 || fsize2==-1)
                totalSize= -1;
        else
                totalSize= fsize1+fsize2;

        return totalSize;
  }

  public MyFile(String n1, String n2) {
        fname1=n1;
        fname2=n2;
        fsize1=getFileSize(fname1);
        fsize2=getFileSize(fname2);
  }

  long getFileSize(String fname) {
        File file = new File(fname);
        if (!file.exists() || !file.isFile()) {
                return -1;
        } else{
                return file.length();
        }

  }

  void printInfo() {
        System.out.println("<br>File Name 1:" + fname1 + " size: " + getFileSize(fname1));
        System.out.println("<br>File Name 2:" + fname2 + " size: " + getFileSize(fname2));
        System.out.println("<br>Total size: " + getTotalSize());
  }

}
