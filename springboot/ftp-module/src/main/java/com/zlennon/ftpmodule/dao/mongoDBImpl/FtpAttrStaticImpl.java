package com.zlennon.ftpmodule.dao.mongoDBImpl;


import com.zlennon.ftpmodule.dao.FtpAttrDao;
import com.zlennon.ftpmodule.entity.FileOperater;
import com.zlennon.ftpmodule.entity.FtpAttr;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Administrator on 2017/6/2.
 */
public class FtpAttrStaticImpl implements FtpAttrDao {
    @Override
    public FtpAttr getFtpAttr(String remotePath, String filename) {

          FtpAttr fa=   new FtpAttr();
          fa.setUrl("127.0.0.1");
          fa.setPort(21);
          fa.setPassword("admin");
          fa.setUsername("admin");
          fa.setRemotePath(remotePath);
          fa.setFileName(filename);
          fa.setLocalPath("D:/test/download/");
            return  fa;
    }

    @Override
    public FTPClient getFTPClient() {
        return new FTPClient();
    }

    @Override
    public FileOperater getOperators(FileOperater fo) {
        return fo;
    }
}
