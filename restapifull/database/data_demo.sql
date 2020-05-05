-- Create user
INSERT INTO public.registered_user (email, first_name, last_name, "password",roles)
VALUES
  (
    'ccathala.dev@gmail.com',
    'user',
    'userLastName',
    '$2a$10$1nAVWVhiESnNhYSTMr03N.w2tR0zeqS5YYq9rK7Atb503qa7ksc8K',
    'USER'
  );
 
-- Create book
INSERT INTO public.book (
    author_first_name,
    author_last_name,
    pictureurl,
    publication_date,
    synopsis,
    title
  )
VALUES
  (
    'Franck',
    'Herbert',
    '/covers/dune_cover.jpg',
    '2005-06-09',
    'Il n''y a pas, dans tout l''Empire, de planète plus inhospitalière que Dune. Partout des sables à perte de vue. Une seule richesse: l''épice de longue vie, née du désert, et que tout l''univers achète à n''importe quel prix. Richesse très convoitée : quand Leto Atréides reçoit Dune en fief, il flaire le piège. Il aura besoin des guerriers Fremen qui, réfugiés au fond du désert, se sont adaptés à une vie très dure en préservant leur liberté, leurs coutumes et leur foi mystique. Ils rêvent du prophète qui proclamera la guerre sainte et qui, à la tête des commandos de la mort, changera le cours de l''histoire.
Cependant les Révérendes Mères du Bene Gesserit poursuivent leur programme millénaire de sélection génétique ; elles veulent créer un homme qui concrétisera tous les dons latents de l''espèce. Tout est fécond dans ce programme, y compris ses défaillances.
Le Messie des Fremen est-il déjà né dans l''Empire?',
    'Dune I'
  ),
  (
    'J.R.R.',
    'Tolkien',
    '/covers/lsda_tome1.jpg',
    '2019-03-10',
    'Dans les vertes prairies de la Comté, les Hobbits, ou Semi-hommes, vivaient en paix... Jusqu''au jour fatal où l''un d''entre eux, au cours de ses voyages, entra en possession de l''Anneau Unique aux immenses pouvoirs. Pour le reconquérir, Sauron, le seigneur ténébreux, va déchaîner toutes les forces du Mal... Frodon, le Porteur de l''Anneau, Gandalf, le magicien, et leurs intrépides compagnons réussiront-t-ils à écarter la menace qui pèse sur la Terre du Milieu ?',
    'Le Seigneur des Anneaux - La communauté de l''anneau'
  ),
  (
    'Bernard',
    'Werber',
    '/covers/les_fourmis.jpeg',
    '2002-08-24',
    'Le temps que vous lisiez ces lignes, sept cents millions de fourmis seront nées sur la planète. Sept cents millions d''individus dans une communauté estimée à un milliard de milliards, et qui a ses villes, sa hiérarchie, ses colonies, son langage, sa production industrielle, ses esclaves, ses mercenaires... Ses armes aussi. Terriblement destructrices. Lorsqu''il entre dans la cave de la maison léguée par un vieil oncle entomologiste, Jonathan Wells est loin de se douter qu''il va à leur rencontre. A sa suite, nous allons découvrir le monde fabuleusement riche, monstrueux et fascinant de ces "infra terrestres", au fil d''un thriller unique en son genre, où le suspense et l''horreur reposent à chaque page sur les données scientifiques les plus rigoureuses. Voici pour la première fois un roman dont les héros sont des... fourmis.',
    'Les fourmis'
  );
 
 
-- Create Library
INSERT INTO public. "library" ("name")
VALUES
  ('Bayonne'),
  ('Anglet'),
  ('Biarritz');

-- Create Available copie

INSERT INTO public.available_copie
(book_id, library_id, owned_quantity, available_quantity)
VALUES
(1, 1, 2, 1),
(1, 2, 2, 2),
(1, 3, 2, 2),
(2, 1, 2, 1),
(2, 2, 2, 2),
(2, 3, 2, 2),
(3, 1, 2, 1),
(3, 2, 2, 2),
(3, 3, 2, 2);

-- Create Borrow
INSERT INTO public.borrow (
    book_returned,
    borrow_date,
    extended_duration,
    return_date,
    book_id,
    library_id,
    registered_user_id
  )
VALUES
  (
    false,
    '2019-11-01',
    false,
    '2019-12-01',
    1,
    1,
    1
  ),
  (
    false,
    '2020-01-17',
    false,
    '2020-02-14',
    2,
    1,
    1
  ),
  (
    false,
    '2020-01-17',
    false,
    '2020-02-14',
    3,
    1,
    1
  )
  ;

