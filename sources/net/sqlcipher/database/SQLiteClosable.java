package net.sqlcipher.database;

public abstract class SQLiteClosable {
    private Object mLock = new Object();
    private int mReferenceCount = 1;

    /* access modifiers changed from: protected */
    public abstract void onAllReferencesReleased();

    /* access modifiers changed from: protected */
    public void onAllReferencesReleasedFromContainer() {
    }

    public void acquireReference() {
        synchronized (this.mLock) {
            int i = this.mReferenceCount;
            if (i > 0) {
                this.mReferenceCount = i + 1;
            } else {
                throw new IllegalStateException("attempt to re-open an already-closed object: " + getObjInfo());
            }
        }
    }

    public void releaseReference() {
        synchronized (this.mLock) {
            int i = this.mReferenceCount - 1;
            this.mReferenceCount = i;
            if (i == 0) {
                onAllReferencesReleased();
            }
        }
    }

    public void releaseReferenceFromContainer() {
        synchronized (this.mLock) {
            int i = this.mReferenceCount - 1;
            this.mReferenceCount = i;
            if (i == 0) {
                onAllReferencesReleasedFromContainer();
            }
        }
    }

    private String getObjInfo() {
        StringBuilder buff = new StringBuilder();
        buff.append(getClass().getName());
        buff.append(" (");
        if (this instanceof SQLiteDatabase) {
            buff.append("database = ");
            buff.append(((SQLiteDatabase) this).getPath());
        } else if ((this instanceof SQLiteProgram) || (this instanceof SQLiteStatement) || (this instanceof SQLiteQuery)) {
            buff.append("mSql = ");
            buff.append(((SQLiteProgram) this).mSql);
        }
        buff.append(") ");
        return buff.toString();
    }
}
