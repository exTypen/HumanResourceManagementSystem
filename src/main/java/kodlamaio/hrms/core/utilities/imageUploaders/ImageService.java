package kodlamaio.hrms.core.utilities.imageUploaders;

import kodlamaio.hrms.core.utilities.result.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ImageService {
    DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
    DataResult<Map> delete (String id) throws IOException;
}
