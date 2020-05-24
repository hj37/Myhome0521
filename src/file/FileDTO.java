package file;

public class FileDTO {
	String fileName;
	String fileRealName;
	int downloadCount;
	String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileRealName() {
		return fileRealName;
	}
	
	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}


	
}
