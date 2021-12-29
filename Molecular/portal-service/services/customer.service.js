module.exports = {
	name: "customer",

	/**
	 * Actions
	 */
	actions: {

		/**
		 * Welcome, a username
		 *
		 * @param {String} customerId
		 */
		customer: {
			rest: "/customer",
			params: {
				customerId: "string"
			},
			/** @param {Context} ctx  */
			async handler(ctx) {
				return `Customer detials of customer ID : , ${ctx.params.customerId}`;
			}
		}
	},

};
