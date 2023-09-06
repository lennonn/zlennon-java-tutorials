package com.zlennon.ftpmodule.dao;

import com.zlennon.ftpmodule.entity.FileOperater;
import com.zlennon.ftpmodule.entity.FtpAttr;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Administrator on 2017/6/2.
 */
public interface FtpAttrDao {
    public FtpAttr getFtpAttr(String remotePath, String fileName);
    public FTPClient getFTPClient();
    public FileOperater getOperators(FileOperater fo);
}
