package fr.dawan.ctrl;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

public class Ctrl {

	protected boolean error= false;

	//********************Getters / Setters******************
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	
	//********************Methods Utilitaires****************
	protected static String MySQLPassword(String password) {
        byte[] utf8 = null;
		try {
			utf8 = password.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return "*" + DigestUtils.sha1Hex(DigestUtils.sha1(utf8)).toUpperCase();
	}
}
