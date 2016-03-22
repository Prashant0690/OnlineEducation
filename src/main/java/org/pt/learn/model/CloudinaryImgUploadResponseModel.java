package org.pt.learn.model;

public class CloudinaryImgUploadResponseModel {
	
	private String public_id ;
	
	private String version ;
	
	private String signature ;
	
	private String resource_type ;
	
	private String created_at ;
	
	private String bytes ;
	
	private String type ;
	
	private String url ;
	
	private String secure_url ;

	public String getPublic_id() {
		return public_id;
	}

	public void setPublic_id(String public_id) {
		this.public_id = public_id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getResource_type() {
		return resource_type;
	}

	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getBytes() {
		return bytes;
	}

	public void setBytes(String bytes) {
		this.bytes = bytes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSecure_url() {
		return secure_url;
	}

	public void setSecure_url(String secure_url) {
		this.secure_url = secure_url;
	}

	@Override
	public String toString() {
		return "CloudinaryImgUploadResponseModel [public_id=" + public_id
				+ ", version=" + version + ", signature=" + signature
				+ ", resource_type=" + resource_type + ", created_at="
				+ created_at + ", bytes=" + bytes + ", type=" + type + ", url="
				+ url + ", secure_url=" + secure_url + "]";
	}
	
	
	

}
