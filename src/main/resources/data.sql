insert into user_role(role, description) VALUES("ROLE_ADMIN", "default role for admin");
insert into user(username, password) VALUES("test", "test");
insert into user_roles(user_id, roles_id) VALUES(1, 1);

insert into guests(created_at) VALUES("2017-12-01 12:12:11");
insert into ip_address(ip, guest_id) VALUES("visitErrors", 1);
insert into guests(created_at) VALUES("2017-12-01 12:11:10");
insert into ip_address(ip, guest_id) VALUES("admin", 2);

insert into site_content(path, description_pl, description_en) VALUES("about", "Witam!<br> Nazywam się <strong>Artur Paszkiewicz</strong> i od około półtora roku uczę się głównie samemu programowania. Z pomocą przychodzą mi kursy, książki i internet.<br> Na mojej stronie opisałem stworzone przeze mnie dotychczas projekty, a także recenzje zrobionych przeze mnie kursów i przeczytanych książek. Ponadto uczęszczam do szkoły policealnej na kierunku technik-informatyk (Centrum Nauki i Biznesu „Żak”).  Aktualnie jestem na czwartym – ostatnim semestrze. Jeśli zainteresowała Państwa moja osoba, zapraszam do kontaktu (zakładka „Kontakt”).<br><br>Znane mi technologie:<br><ul><li>Java</li><li>Spring</li><li>Angular 5</li><li>SQL</li><li>Hibernate</li><li>AngularJS</li><li>Javascript</li><li>JQuery</li><li>", "Welcome on my site!<br>I'm a self-taught <i>Programmer</i>");
insert into site_content(path, description_pl, description_en) VALUES("contact", "Jeśli jesteś zainteresowany moją osobą, portfolio lub też masz jakieś uwagi dotyczące strony, zapraszam do kontaktu ze mną przez email lub formularz obok. Mój email: <strong>paszkiewicz.artur@gmail.com</strong>", "E-mail: <strong>example@example.com</strong><br>You can also use a form.");
insert into site_content(path, description_pl, description_en) VALUES("home", "Witam na mojej stronie!<br>Nazywam się <strong>Artur Paszkiewicz</strong> i goszczę Cię na swoim programistycznym <strong>portfolio</strong>.<br>Zapraszam Cię do rozejrzenia się.", "Welcome on my site!<br>My name is <strong>Artur Paszkiewicz</strong> and you are visiting my programing<strong>portfolio</strong>.<br>I invite you to take a look around.");

insert into links(site, entity_id, link_type) VALUES(0, 1, 0);
insert into links(site, entity_id, link_type) VALUES(0, 1, 2);
insert into links(site, entity_id, link_type) VALUES(1, 1, 0);
insert into links(site, entity_id, link_type) VALUES(1, 1, 1);
insert into links(site, entity_id, link_type) VALUES(6, 1, 0);

insert into tags(path, name, name_en, amount, added) VALUES("java", "Java", "Java", 5, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("angular", "Angular", "Angular", 2, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("spring", "Spring", "Spring", 4, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("css", "css", "css", 1, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("html", "html", "html", 2, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("php", "php", "php", 3, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("sql", "sql", "sql", 4, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("python", "python", "python", 1, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("android", "android", "android", 3, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("clean-code", "Czysty kod", "Clean code", 5, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("web", "Web", "Web", 1, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("jquery", "jQuery", "JQuery", 2, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("c++", "C++", "C++", 3, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("projektowanie", "projektowanie", "projektowanie", 4, "2017-12-10");
insert into tags(path, name, name_en, amount, added) VALUES("grafika", "grafika", "grafika", 5, "2017-12-10");
insert into links(site, entity_id, link_type) VALUES(5, 1, 0);
insert into links(site, entity_id, link_type) VALUES(5, 2, 0);
insert into links(site, entity_id, link_type) VALUES(5, 3, 0);

insert into books(name, path, author, description_pl, description_en, rating, image_path, link, pages, have_read, posted, last_update, comments_available, search_string) VALUES("Myślenie w Javie", "thinking-in-java", "Jakiś autor", "Bardzo dobra pozycja dla osób początkujących. Omawia takie tematy jak rekurencja, derekursywacja (zamiana rekurencji na postać iteracyjną), podstawowe typy i struktury danych, grafy. Porusza także zagadnienia algorytmów sortujących i przeszukiwania tekstu. W książce zostały też przedstawione metody obliczania złożoności obliczeniowej. Uważam ją za ciekawą pozycję, którą chętnie się czytało. Jedynie pewną trudność sprawia zrozumienie wyższej matematyki potrzebne do obliczania złożoności obliczeniowej. Ta pozycja jest wartościowym wstępem do tematyki algorytmów i struktur danych.", "Opis angielski thinking in java", 8, "/assets/czysty-kod-martin.png", "http://google.pl", 100, "2016-12-03",  "2017-12-03", "2017-12-03", true, "Myślenie w Javie Jakiś autor Opis polski thinking in java Opis angielski thinking in java http://google.pl");
insert into books(name, path, author, description_pl, description_en, rating, image_path, link, pages, have_read, posted, last_update, comments_available, search_string) VALUES("Sass dla opornych", "sass", "Jakiś inny autor", "Opis polski sass", "Opis angielski sass", 10, "/assets/pierwsze-kroki-sql-nield.png", "http://onet.pl", 100, "2016-06-03", "2017-11-03", "2017-11-03", true, "Sass dla opornych Jakiś inny autor Opis polski sass Opis angielski sass http://onet.pl");
insert into books(name, path, author, description_pl, description_en, rating, image_path, link, pages, have_read, posted, last_update, comments_available, search_string) VALUES("Sass dla opornych", "czysty-kod", "Jakiś inny autor", "Opis polski sass", "Opis angielski sass", 10, "/assets/ocpjp-lipinski.png", "http://onet.pl", 100, "2016-06-03", "2017-11-03", "2017-11-03", true, "Sass dla opornych Jakiś inny autor Opis polski sass Opis angielski sass http://onet.pl");
insert into links(site, entity_id, link_type) VALUES(4, 1, 0);
insert into links(site, entity_id, link_type) VALUES(4, 1, 1);
insert into links(site, entity_id, link_type) VALUES(4, 2, 0);
insert into links(site, entity_id, link_type) VALUES(4, 2, 1);
insert into links(site, entity_id, link_type) VALUES(4, 3, 0);
insert into links(site, entity_id, link_type) VALUES(4, 3, 1);
insert into book_tags(book_id, tag_id) VALUES (1, 1);
insert into book_tags(book_id, tag_id) VALUES (1, 2);
insert into book_tags(book_id, tag_id) VALUES (2, 1);
insert into book_tags(book_id, tag_id) VALUES (2, 3);

insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Java Świetna książka", "Michał", 1, null);
insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-02 12:11:10", "Wspaniała książka pisana w Javie", "Maks", 1, 1);
insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-03 12:11:10", "Cudowna książka", "Marcin", 1, 1);
insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-09 12:11:10", "Wyśmienita książka", "Mikołaj", 1, 3);
insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-10 12:11:10", "Piękna książka", "Ministrant", 1, 1);
insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-08 12:11:10", "Niesamowita książka", "Mormon", 1, null);
insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-11 12:11:10", "Nieprzeciętna książka", "MichaelAngelo", 1, 3);

insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-07 12:11:10", "Super książka", "Siostrzeniec", 2, null);
insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-08 12:11:10", "Mega książka", "Szeryf", 2, null);
insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-11 12:11:10", "Hiper książka", "Szperacz", 2, null);
insert into comments(posted, content, nickname, book_id, comment_parent_id) VALUES("2017-12-12 12:11:10", "Ekstra książka", "Syzyf", 2, 9);

insert into courses(name, path, author, description_pl, description_en, rating, image_path, link, length_in_hours, have_read, posted, last_update, comments_available, search_string) VALUES("Angular 5", "new-angular", "Maximilian SchwarzMuller", "Bardzo dobry kurs", "Very good course", 9, "/assets/advanced-javascript.png", "https://www.udemy.com/the-complete-guide-to-angular-2/", 27, "2017-12-01", "2017-12-02", "2017-12-03", true, "Angular 5 Maximilian SchwarzMuller Bardzo dobry kurs Very good course https://www.udemy.com/the-complete-guide-to-angular-2/");
insert into courses(name, path, author, description_pl, description_en, rating, image_path, link, length_in_hours, have_read, posted, last_update, comments_available, search_string) VALUES("Javascript", "javascript", "Asim Hussain", "Niezwykle dobry kurs", "Extremely good course", 10, "/assets/javastart-podstawowy.png", "https://www.udemy.com/top-javascript-interview-questions-and-answers/", 3.5 , "2017-12-04", "2017-12-05", "2017-12-06", true, "Javascript Asim Hussain Niezwykle dobry kurs Extremely good course https://www.udemy.com/top-javascript-interview-questions-and-answers/");
insert into links(site, entity_id, link_type) VALUES(3, 1, 0);
insert into links(site, entity_id, link_type) VALUES(3, 1, 1);
insert into links(site, entity_id, link_type) VALUES(3, 2, 0);
insert into links(site, entity_id, link_type) VALUES(3, 2, 1);
insert into course_tags(course_id, tag_id) VALUES (1, 3);
insert into course_tags(course_id, tag_id) VALUES (1, 2);
insert into course_tags(course_id, tag_id) VALUES (2, 3);
insert into course_tags(course_id, tag_id) VALUES (2, 1);

insert into comments(posted, content, nickname, course_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Java Kurs cudo", "Antoni", 1, null);
insert into comments(posted, content, nickname, course_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Kurs magia", "Anastazy", 1, 12);
insert into comments(posted, content, nickname, course_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Kurs śmietanka", "Andrzej", 1, 13);

insert into comments(posted, content, nickname, course_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Kurs malinka", "Nicpoń", 2, null);
insert into comments(posted, content, nickname, course_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Kurs wisienka", "Niesforny", 2, null);
insert into comments(posted, content, nickname, course_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Kurs czeresieńka", "Nieokrzesany", 2, null);

insert into projects(name, path, description_pl, description_en, image_path, github_link, link, length_pl, length_en, posted, last_update, work_started, comments_available, search_string) VALUES("Scoutbook - facebook alternative", "scoutbook", "Bardzo czasochłonny projekt", "Very time-consuming project", "/assets/scoutbook.png", "https://github.com/paszkiewiczartur/scoutbook", "http://arturpaszkiewicz.pl", "1,5 miesiąca", "1,5 month", "2017-12-01", "2017-12-02", "2017-12-03", true, "Scoutbook - facebook alternative Bardzo czasochłonny projekt Very time-consuming project https://github.com/paszkiewiczartur/scoutbook http://arturpaszkiewicz.pl 1,5 miesiąca 1,5 month");
insert into projects(name, path, description_pl, description_en, image_path, github_link, link, link_to_download, length_pl, length_en, posted, last_update, work_started, comments_available, search_string) VALUES("Timer - app for measuring your work time", "timer", "Przyjemny layout", "Pleasant layout", "/assets/portfolio-frontend.png", "https://github.com/paszkiewiczartur/Timer-Angular-4", "http://arturpaszkiewicz.pl:8081", "test.rar", "1 tydzień", "1 week", "2017-12-04", "2017-12-05", "2017-12-06", true, "Timer - app for measuring your work time Przyjemny layout Pleasant layout https://github.com/paszkiewiczartur/Timer-Angular-4 http://arturpaszkiewicz.pl:8081 1 tydzień 1 week");
insert into links(site, entity_id, link_type) VALUES(2, 1, 0);
insert into links(site, entity_id, link_type) VALUES(2, 1, 1);
insert into links(site, entity_id, link_type) VALUES(2, 1, 3);
insert into links(site, entity_id, link_type) VALUES(2, 2, 0);
insert into links(site, entity_id, link_type) VALUES(2, 2, 1);
insert into links(site, entity_id, link_type) VALUES(2, 2, 2);
insert into links(site, entity_id, link_type) VALUES(2, 2, 3);
insert into project_tags(project_id, tag_id) VALUES (1, 1);
insert into project_tags(project_id, tag_id) VALUES (2, 1);
insert into project_tags(project_id, tag_id) VALUES (2, 3);

insert into comments(posted, content, nickname, project_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Projekt jak klocki Lego", "Huncwot", 1, null);
insert into comments(posted, content, nickname, project_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Projekt jak Samsung", "Chad", 1, null);
insert into comments(posted, content, nickname, project_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Projekt jak Porsche", "Cham", 1, 19);

insert into comments(posted, content, nickname, project_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Projekt jak Barwy Szczęścia", "Ladaco", 2, null);
insert into comments(posted, content, nickname, project_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Projekt jak O mnie się nie martw", "Lelum Polelum", 2, 21);
insert into comments(posted, content, nickname, project_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Projekt jak Klan", "Lizus", 2, null);
insert into comments(posted, content, nickname, project_id, comment_parent_id) VALUES("2017-12-01 12:11:10", "Projekt jak Na Wspólnej", "Leżajsk", 2, 23);
