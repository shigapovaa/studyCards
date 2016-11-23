package ru.startandroid.study_cards001.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbAdapter {
    //поля базы данных
    public static final String KEY_ROWID = DatabaseHelper.KEY_ROWID;
    public static final String KEY_LEVEL = DatabaseHelper.KEY_LEVEL;
    public static final String KEY_QUESTION = DatabaseHelper.KEY_QUESTION;
    public static final String KEY_ANSWER = DatabaseHelper.KEY_ANSWER;
    //название базы данных
    private static final String DATABASE_TABLE = DatabaseHelper.DATABASE_TABLE;

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public DbAdapter(Context context) {
        this.context = context;
    }

    //открыть базу данных
    public DbAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    //закрыть базу данных
    public void close() {
        dbHelper.close();
    }

    //создать новую карточку в бд, если создан успешно - возвращается номер строки rowId иначе -1
    public long createTodo(int level, String question, String answer) {
        ContentValues initialValues = createContentValues(level, question, answer);
        return database.insert(DATABASE_TABLE, null, initialValues);
    }

    //изменить уровень карточки
    public boolean updateLevel(long rowId, int level) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_LEVEL, level);
        return database.update(DATABASE_TABLE, cv, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //удалить карточку из бд
    public boolean deleteCard(long rowId) {
        return database.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //вернуть курсор со всеми картами уровня
    public Cursor fetchAllLevelCards(int level) {
        return database.query(DATABASE_TABLE, new String[]{KEY_ROWID,
                KEY_LEVEL, KEY_QUESTION, KEY_ANSWER}, KEY_LEVEL + "=" + level, null, null, null, null);
    }

    //создать контент
    private ContentValues createContentValues(int level, String question, String answer) {
        ContentValues values = new ContentValues();
        values.put(KEY_LEVEL, level);
        values.put(KEY_QUESTION, question);
        values.put(KEY_ANSWER, answer);
        return values;
    }
}