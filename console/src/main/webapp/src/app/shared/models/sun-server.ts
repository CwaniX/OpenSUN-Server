export enum SUNServerCategory {
    AUTH = 'AUTH',
    AGENT = 'AGENT',
    GAME = 'GAME',
    WORLD = 'WORLD',
    DBPROXY = 'DBPROXY'
}

export class SUNServer {
    public id: number;
    public ip: string;
    public port: string;
    public category: SUNServerCategory;
    public username: string;
    public password: string;
}
