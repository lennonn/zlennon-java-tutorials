package com.zlennon.ftpmodule.service.impl;


import com.zlennon.ftpmodule.entity.DtsFtpFile;
import com.zlennon.ftpmodule.entity.FileOperater;
import com.zlennon.ftpmodule.entity.FtpAttr;
import com.zlennon.ftpmodule.service.AbstractFtpClientOpr;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
public class ListMapFtp extends AbstractFtpClientOpr {
    private Logger log = LogManager.getLogger(ListMapFtp.class);

    //private FtpAttr ftpAttr;

   // private FTPClient ftpClient;
    //FileOperater fileOperater;



    public ListMapFtp(FtpAttr ftpAttr, FileOperater fileOperater) {
        super(ftpAttr,  fileOperater);
    }
    @Override
    public  List<List<DtsFtpFile>> showList() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<DtsFtpFile> listFile = new ArrayList<DtsFtpFile>();
        List<DtsFtpFile> listDirectory = new ArrayList<DtsFtpFile>();
        listMap= new ArrayList<List<DtsFtpFile>>();
        try {
            FTPFile[] fs = ftpClient.listFiles();
            for (FTPFile ftpFile : fs) {
                DtsFtpFile dtsFtpFile = new DtsFtpFile();
                dtsFtpFile.setName(ftpFile.getName());
                dtsFtpFile.setSize(ftpFile.getSize());
                dtsFtpFile.setLastedUpdateTime(formatter.format(ftpFile.getTimestamp().getTime()));
                if (ftpFile.getType() == 1 && !ftpFile.getName().equals(".") && !ftpFile.getName().equals("..")) {
                    dtsFtpFile.setLocalPath(ftpAttr.getRemotePath() + "/" + ftpFile.getName());
                    listDirectory.add(dtsFtpFile);
                } else if (ftpFile.getType() == 0) {
                    dtsFtpFile.setLocalPath(ftpAttr.getRemotePath() + "/");
                    listFile.add(dtsFtpFile);
                }
            }
            listMap.add(listDirectory);
            listMap.add(listFile);
            this.logout();

        } catch (IOException e) {
            log.error("error!");
        }
        return listMap;
    }
}
