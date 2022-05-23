package pl.redx.project.questions.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.redx.project.questions.dto.CategoriesDto;
import pl.redx.project.questions.dto.QuestionsDto;
import pl.redx.project.questions.frontend.GameOptions;

import java.net.URI;
import java.util.List;

@Service
@Log
public class QuestionsDataService {

    public List<CategoriesDto.CategoryDto> getCategories() {
        RestTemplate restTemplate = new RestTemplate();
        CategoriesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
        log.info("Categories: " + result.getCategories());
        return result.getCategories();
    }
    public List<QuestionsDto.QuestionDto> getQuestions(GameOptions gameOptions) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://opentdb.com/api.php")
                .queryParam("amount", gameOptions.getNumberOfQuestions())
                .queryParam("category", gameOptions.getCategoryId())
                .queryParam("difficulty", gameOptions.getDifficulty().name().toLowerCase())
                .build().toUri();
        log.info("Question retrieve URL: " + uri);

        QuestionsDto result = restTemplate.getForObject(uri, QuestionsDto.class);
        log.info("Questions: " + result.getResults());
        return result.getResults();
    }
}
