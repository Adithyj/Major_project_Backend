package com.example.Medicinal_Backend.service;

import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Image;
import com.google.protobuf.ByteString;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class VisionService {

    public List<String> detectLabels(byte[] imageBytes) throws IOException {
        ByteString imgBytes = ByteString.copyFrom(imageBytes);
        Image img = Image.newBuilder().setContent(imgBytes).build();

        Feature feature = Feature.newBuilder().setType(Feature.Type.LABEL_DETECTION).build();
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                .addFeatures(feature)
                .setImage(img)
                .build();

        List<String> labels = new ArrayList<>();

        try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(Collections.singletonList(request));
            List<EntityAnnotation> annotations = response.getResponses(0).getLabelAnnotationsList();

            for (EntityAnnotation annotation : annotations) {
                labels.add(annotation.getDescription());
            }
        }

        return labels;
    }
}
