# Five-minute demo script

1. Start the app with `mvn spring-boot:run`, then open `http://localhost:6969`.
2. Point out that the login card has Bootstrap icons and that the three test accounts are visible. Try `mb@a.com / mb` to show that blocked users cannot sign in.
3. Sign in as `ad@a.com / ad`. On the dashboard, explain the three statistic cards and the low-stock table. Toggle dark mode; refresh the page to show the choice persists.
4. Open **Products**. Search for `Sách`, then move to another page. Explain that pagination preserves the search keyword and uses Spring Data `Pageable`.
5. Create a product. First enter an invalid quantity such as `2` to show Bean Validation. Then enter a valid ID, name, quantity, price, and category and save it.
6. Edit that product, then delete it. Point out the single reusable Bootstrap confirmation modal instead of a browser confirmation dialog.
7. Sign out and sign in as `st@a.com / st`. The create/edit/delete controls are gone. Type `/products/new` in the address bar to show server-side authorization redirects staff safely.

## Screenshots for slides

- Login page with demo-account card.
- Dashboard in light mode and dashboard in dark mode.
- Products search results with a low-stock badge and pagination.
- Product form showing validation feedback.
- Reusable delete confirmation modal.
- Staff view with no management buttons (or its authorization message).
- `pom.xml` WebJar dependencies and a template line using `/webjars/...`.
