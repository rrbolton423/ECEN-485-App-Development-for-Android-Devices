package com.romellbolton.contentproviderapp;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by romellbolton on 3/22/18.
 */

// Have Provider class extend ContentProvider
public class StudentsProvider extends ContentProvider {

    // Create constants for the name of the Provider
    static final String PROVIDER_NAME = "com.romellbolton.contentproviderapp.StudentsProvider";
    static final String URL = "content://" + PROVIDER_NAME + "/students";
    static final Uri CONTENT_URI = Uri.parse(URL);

    // Create constants for the column names of the database
    static final String _ID = "_id";
    static final String NAME = "name";
    static final String GRADE = "grade";

    // Create constants to match against the URI matcher
    static final int STUDENTS = 1;
    static final int STUDENT_ID = 2;

    // Create URI Matcher
    static final UriMatcher uriMatcher;

    // Create static initializer block
    static {

        // Instantiate the URI matcher
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        // Add both URI combinations, one that returns all rows, another
        // that returns a specific row based on an ID that is passed with the query
        uriMatcher.addURI(PROVIDER_NAME, "students", STUDENTS);
        uriMatcher.addURI(PROVIDER_NAME, "students/#", STUDENT_ID);
    }

    /**
     * Database specific constant declarations
     */

    // Define Database instance
    private SQLiteDatabase db;

    // Create Database name
    static final String DATABASE_NAME = "College";

    // Create Database Table name
    static final String STUDENTS_TABLE_NAME = "students";

    // Create Database Version
    static final int DATABASE_VERSION = 1;

    // Create SQL statement to create Database Table
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + STUDENTS_TABLE_NAME +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " grade TEXT NOT NULL);";

    /**
     * Helper class that actually creates and manages
     * the provider's underlying data repository.
     */

    // Have Database class extend SQLiteOpenHelper
    private static class DatabaseHelper extends SQLiteOpenHelper {

        // Create required constructor, passing the context, name of the database, and it's version
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        // Implement the onCreate() method which is called once when the database is initially created
        @Override
        public void onCreate(SQLiteDatabase db) {

            // Execute the SQL Statement to create the Database table
            db.execSQL(CREATE_DB_TABLE);
        }

        // Implement the onUpgrade() method which is called only when the database
        // version is incremented
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            // Drop the old table
            db.execSQL("DROP TABLE IF EXISTS " + STUDENTS_TABLE_NAME);

            // Create the new table
            onCreate(db);
        }
    }

    // onCreate is called when ContentProvider starts up
    @Override
    public boolean onCreate() {

        // Get the current context of the application
        Context context = getContext();

        // Create an instance of the DatabaseHelper class
        DatabaseHelper dbHelper = new DatabaseHelper(context);

        /**
         * Create a writable database which will trigger its
         * creation if it doesn't already exist.
         */

        // Get an instance of a writable database
        db = dbHelper.getWritableDatabase();

        // If the database is not null return true,
        // else, return false
        return (db == null) ? false : true;
    }

    // insert() inserts a new row into the database, and
    // is called directly by the ContentResolver
    @Override
    public Uri insert(Uri uri, ContentValues values) {

        /**
         * Add a new student record
         * insert returns whatever row the data was inserted to
         */
        long rowID = db.insert(STUDENTS_TABLE_NAME, "", values);

        /**
         * If record is added successfully
         */

        // If there was a row inserted...
        if (rowID > 0) {

            // Create the URI to the inserted data
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);

            // Notify observers that a change in the database was made
            getContext().getContentResolver().notifyChange(_uri, null);

            // Return the URI of the data inserted
            return _uri;
        }

        // Throw a SQLException
        throw new SQLException("Failed to add a record into " + uri);
    }

    // query() executes a query on the database and returns a cursor object containing the data
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        // Create a QueryBuilder object to buildup a query to eventually execute
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        // Set the specified table to query on the queryBuilder
        queryBuilder.setTables(STUDENTS_TABLE_NAME);

        // Match the URI passed into the method
        switch (uriMatcher.match(uri)) {

            // In the case that the URI passed in does NOT contains a specific row in the database
            case STUDENTS:

                // Break from the switch statement
                break;

            // In the case that the URI passed in contains a specific row in the database...
            case STUDENT_ID:

                // Append a where clause, specifying the row # / ID of the query
                queryBuilder.appendWhere(_ID + "=" + uri.getPathSegments().get(1));

                // Break from the switch statement
                break;

            // In the case of default...
            default:

                // Exception handle
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        // If the sort order is not null and is not an empty String...
        if (sortOrder == null || sortOrder == "") {

            /**
             * By default sort on student names
             */

            // Set the sort order on the "NAME" column
            sortOrder = NAME;
        }

        // Use the Query Builder to execute the query with the specified arguments
        // Create a cursor object that is returned from the query
        Cursor cursor = queryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);

        /**
         * register to watch a content URI for changes
         */
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        // Return the cursor
        return cursor;
    }

    // delete() deletes an existing row from the database, and
    // is called directly by the ContentResolver
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        // Create count variable to keep track of the amount of rows deleted in the database
        int count = 0;

        // Match the URI passed into the method
        switch (uriMatcher.match(uri)) {

            // In the case that the URI passed in does NOT contains a specific row in the database
            case STUDENTS:

                // Delete all rows in the database
                count = db.delete(STUDENTS_TABLE_NAME, selection, selectionArgs);

                // Break from the switch statement
                break;

            // In the case that the URI passed in contains a specific row in the database...
            case STUDENT_ID:

                // Get the ID / row of the URI passed in
                String id = uri.getPathSegments().get(1);

                // Delete a specific row from the database using the ID of the URI passed in
                count = db.delete(STUDENTS_TABLE_NAME, _ID + " = " + id +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);

                // Break from the switch statement
                break;

            // In the case of default...
            default:

                // Exception handle
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        /**
         * Register to watch a content URI for changes
         */
        getContext().getContentResolver().notifyChange(uri, null);

        // Return the amount of rows deleted in the database
        return count;
    }

    // update() updates an existing row in the database, and
    // is called directly by the ContentResolver
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        // Create count variable to keep track of the amount of rows updated in the database
        int count = 0;

        // Match the URI passed into the method
        switch (uriMatcher.match(uri)) {

            // In the case that the URI passed in does NOT contains a specific row in the database
            case STUDENTS:

                // Update all rows in the database
                count = db.update(STUDENTS_TABLE_NAME, values, selection, selectionArgs);

                // Break from the switch statement
                break;

            // If the URI passed contains a specific row in the database...
            case STUDENT_ID:

                // Update a specific row in the database using the ID of the URI passed in
                count = db.update(STUDENTS_TABLE_NAME, values, _ID + " = " + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);

                // Break from the switch statement
                break;

            // In the case of default...
            default:

                // Exception handle
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        /**
         * Register to watch a content URI for changes
         */
        getContext().getContentResolver().notifyChange(uri, null);

        // Return the amount of rows updated in the database
        return count;
    }

    // getType() returns the MIME type of the data in the given URI
    @Override
    public String getType(Uri uri) {

        // Match the URI passed into the method
        switch (uriMatcher.match(uri)) {

            /**
             * Get all student records
             */

            // In the case that the URI passed in does NOT contains a specific row in the database
            case STUDENTS:
                return "vnd.android.cursor.dir/vnd.example.students";

            /**
             * Get a particular student
             */

            // If the URI passed contains a specific row in the database...
            case STUDENT_ID:
                return "vnd.android.cursor.item/vnd.example.students";

            // In the case of default...
            default:

                // Exception handle
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }
}
