package kodlamaio.hrms.core.utilities.imageUploaders;

import com.cloudinary.Cloudinary;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryManager implements ImageService{

    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryManager() {
        valuesMap.put("cloud_name","dwlfg8ogv" );
        valuesMap.put("api_key", "411884968266823" );
        valuesMap.put("api_secret","WsZxm67EBxiouvUJ0fuicfRQMcA" );
        cloudinary = new Cloudinary(valuesMap);
    }

    @Override
    public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
        Map<String , Object > options = new HashMap<>();
        var allowedFormats = Arrays.asList("png","jpg","jpeg");
        options.put("allowed_formats",allowedFormats);
        File file = convert(multipartFile);
        Map result= null;
        try {
            result = cloudinary.uploader().upload(file, options);
        }catch (Exception e){
            return new ErrorDataResult<>(e.getMessage());
        }
        file.delete();
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<Map> delete(String id) throws IOException {
        Map<String , Boolean> options = new HashMap<>();
        options.put("invalidate",true);
        Map result = cloudinary.uploader().destroy(id,options);
        return new SuccessDataResult<>(result);
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }
}
