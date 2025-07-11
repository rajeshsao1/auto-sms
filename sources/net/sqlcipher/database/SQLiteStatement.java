package net.sqlcipher.database;

import android.os.SystemClock;
import androidx.sqlite.db.SupportSQLiteStatement;

public class SQLiteStatement extends SQLiteProgram implements SupportSQLiteStatement {
    private final native long native_1x1_long();

    private final native String native_1x1_string();

    private final native void native_execute();

    SQLiteStatement(SQLiteDatabase db, String sql) {
        super(db, sql);
    }

    public void execute() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public long executeInsert() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                return this.mDatabase.lastChangeCount() > 0 ? this.mDatabase.lastInsertRow() : -1;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public int executeUpdateDelete() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                return this.mDatabase.lastChangeCount();
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public long simpleQueryForLong() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                return native_1x1_long();
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public String simpleQueryForString() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                return native_1x1_string();
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }
}
