//package zw.co.afrosoft.controller;
//
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import zw.co.afrosoft.model.File;
//import zw.co.afrosoft.security.service.FileRequest;
//import zw.co.afrosoft.security.service.FileService;
//
//
//import java.io.UnsupportedEncodingException;
//import java.security.NoSuchAlgorithmException;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/file")
//
//public class FileController {
//
//    private final FileService fileService;
//
//
//    public FileController(FileService fileService) {
//        this.fileService = fileService;
//    }
//
//    @PostMapping
//    private ResponseEntity createFile(@RequestBody FileRequest fileRequest){
//        return fileService.createFile(fileRequest);
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<File> uploadFile(@RequestParam("file") MultipartFile file) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//
//    return fileService.saveFile(file);
//    }
//
//    @PutMapping("{id}")
//    private ResponseEntity updateFile(@PathVariable Long id,@RequestBody FileRequest fileRequest){
//        return fileService.updateFile(id,fileRequest);
//    }
//
//    @GetMapping("{id}")
//    private ResponseEntity findFile(@PathVariable Long id){
//        return fileService.findFile(id);
//    }
//
//    @DeleteMapping("{id}")
//    private ResponseEntity deleteFile(@PathVariable Long id){
//        return fileService.deleteFile(id);
//    }
//
//    @GetMapping
//    private Page getAll(@PageableDefault Pageable pageable){
//        return fileService.findFiles(pageable);
//    }
//
//}
