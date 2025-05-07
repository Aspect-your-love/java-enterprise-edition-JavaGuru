package net.aspect.education.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

@Service
@Slf4j
public class ImageService {
    @Value("${app.image.bucket}")
    private String pathSaveImage;

    /**
     *Метод ответственный за загрузку
     * @param imagePath = имя файла картинки;
     * @param content - содержимое файла.
     */
    public void upload(String imagePath, InputStream content){
        Path fullImagePath = Path.of(pathSaveImage, imagePath);

        try(content){
            // На всякий случай создаём директорию
            Files.createDirectories(fullImagePath.getParent());
            // Записываем данные в файл
            Files.write(fullImagePath, content.readAllBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            log.error("А-яй-яй, не получилось картинку сохранить: ", e);
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public Optional<byte[]> get(String imagePath){
        Path fullImagePath = Path.of(pathSaveImage, imagePath);

        return Files.exists(fullImagePath)
                ? Optional.of(Files.readAllBytes(fullImagePath))
                : Optional.empty();
    }
}
