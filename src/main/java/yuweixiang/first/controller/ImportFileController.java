///**
// * Alipay.com Inc.
// * Copyright (c) 2004-2014 All Rights Reserved.
// */
//package yuweixiang.first.controller;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import yuweixiang.first.constants.SpringDemoConstants;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//
///**
// * 到入文件控制器
// *
// * @author wb-yuweixiang
// * @version $Id: ImportFileController.java, v 0.1 2014-10-14 下午08:04:31 wb-yuweixiang Exp $
// */
//@Controller
//public class ImportFileController {
//
//    /**
//     * 初始化
//     *
//     * @param model
//     * @param request
//     * @return 返回跳转页面
//     */
//    @RequestMapping(value = "/upload.htm", method = RequestMethod.GET)
//    public String init(ModelMap model, HttpServletRequest request) {
//
//        return SpringDemoConstants.UPLOAD;
//    }
//
//    /**
//     * 操作
//     *
//     * @param model
//     * @param request
//     * @param file
//     * @param response
//     * @return 返回跳转页面
//     */
//    @RequestMapping(value = "/upload.htm", method = RequestMethod.POST)
//    public String doGet(@RequestParam("filename") MultipartFile file, HttpServletRequest request,
//                        HttpServletResponse response, ModelMap model) {
//
//        if (file == null)
//            return null;
//        //        logger.info(file.getOriginalFilename());
//
//        String name = file.getOriginalFilename();// 获取上传文件名,包括路径
//        //name = name.substring(name.lastIndexOf("\\") + 1);// 从全路径中提取文件名
//        long size = file.getSize();
//        if ((name == null || name.equals("")) && size == 0)
//            return null;
//        try {
//            InputStream in = file.getInputStream();
//            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
//            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
//                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
//                if (xssfSheet == null) {
//                    continue;
//                }
//                // 循环行Row
//                for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
//                    XSSFRow hssfRow = xssfSheet.getRow(rowNum);
//                    if (hssfRow == null) {
//                        continue;
//                    }
//                    // 循环列Cell
//                    for (short cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
//                        XSSFCell xssfCell = hssfRow.getCell(cellNum);
//                        if (xssfCell == null) {
//                            continue;
//                        }
//                        System.out.print("    " + getValue(xssfCell));
//                    }
//                    System.out.println();
//                }
//            }
//
//        } catch (IOException e) {
//            //            logger.error("", e);
//            e.printStackTrace();
//        }
//        //        List<BrandMobileInfoEntity> BrandMobileInfos = brandService.importBrandPeriodSort(in);
//
//        // 改为人工刷新缓存KeyContextManager.clearPeriodCacheData(new
//        // PeriodDimensions());// 清理所有缓存
//        int count = 10;//BrandMobileInfos.size();
//        String strAlertMsg = "";
//        if (count != 0) {
//            strAlertMsg = "成功导入" + count + "条！";
//        } else {
//            strAlertMsg = "导入失败！";
//        }
//        //        logger.info(strAlertMsg);
//        //request.setAttribute("brandPeriodSortList", BrandMobileInfos);
//        //request.setAttribute("strAlertMsg", strAlertMsg);
//
//        request.getSession().setAttribute("msg", strAlertMsg);
//        //        return get(request, response);
//        return SpringDemoConstants.UPLOAD;
//        //return null;
//    }
//
//    @SuppressWarnings("static-access")
//    private String getValue(XSSFCell hssfCell) {
//        return String.valueOf(hssfCell.getStringCellValue());
//    }
//
//    /**
//     * 将MultipartFile 转换为File
//     *
//     * @param stream
//     * @param path
//     * @param savefile
//     * @throws IOException
//     */
//    public static void SaveFileFromInputStream(InputStream stream, String path, String savefile)
//                                                                                                throws IOException {
//        FileOutputStream fs = new FileOutputStream(path + "/" + savefile);
//        //  System.out.println("------------"+path + "/"+ savefile);
//        byte[] buffer = new byte[1024 * 1024];
//        int bytesum = 0;
//        int byteread = 0;
//        while ((byteread = stream.read(buffer)) != -1) {
//            bytesum += byteread;
//            fs.write(buffer, 0, byteread);
//            fs.flush();
//        }
//        fs.close();
//        stream.close();
//    }
//}
