package by.teachmeskills.penkovsky.repositories.impl;

import by.teachmeskills.penkovsky.models.FlashCard;
import by.teachmeskills.penkovsky.models.FlashCardSet;
import by.teachmeskills.penkovsky.repositories.FlashCardRepository;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlashCardRepositoryImpl implements FlashCardRepository {
    private static final PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
    {
        pgSimpleDataSource.setURL(System.getenv("URL"));
        pgSimpleDataSource.setUser(System.getenv("user"));
        pgSimpleDataSource.setPassword(System.getenv("password"));
    }
    @Override
    public List<FlashCardSet> getFlashCardSet() {
        List<FlashCardSet> flashCardSetList = new ArrayList<>();
        try (Connection connection = pgSimpleDataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.flashcard_set");
//            String query = "SELECT * FROM public.flashcard_set;";
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titlePoolCard = resultSet.getString("title");
                FlashCardSet flashCardSet = new FlashCardSet(id, titlePoolCard);
                flashCardSetList.add(flashCardSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flashCardSetList;
    }

    @Override
    public List<FlashCard> getCards() {
        List<FlashCard> flashCardList = new ArrayList<>();
        try {
            Connection connection = pgSimpleDataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.flashcard");
//            String query = "SELECT * FROM public.flashcard";
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titleCard = resultSet.getString("title_cards");
                String question = resultSet.getString("question");
                String answer = resultSet.getString("answer");
                Boolean active = resultSet.getBoolean("learned");
                Integer poolCardId = resultSet.getInt("set_id");
                FlashCard flashcard = new FlashCard(id, titleCard, question, answer, active, poolCardId);
                flashCardList.add(flashcard);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flashCardList;
    }
}

