"use strict";

/**
 * @typedef {import('moleculer').Context} Context Moleculer's Context
 */

module.exports = {
	name: "portal",

	/**
	 * Actions
	 */
	actions: {

		/**
		 * Portal, a username
		 *
		 * @param {String} customerId
		 */
		portal: {
			rest: "/portal",
			params: {
				customerId: "string"
			},
			/** @param {Context} ctx  */
			async handler(ctx) {
				const customer = await ctx.call('customer.customer',{customerId:ctx.params.customerId});
				const address = await ctx.call('address.customer',{customerId:ctx.params.customerId});
				return {customer,address};
			}
		}
	},

	/**
	 * Events
	 */
	events: {

	},

	/**
	 * Methods
	 */
	methods: {

	},

	/**
	 * Service created lifecycle event handler
	 */
	created() {

	},

	/**
	 * Service started lifecycle event handler
	 */
	async started() {

	},

	/**
	 * Service stopped lifecycle event handler
	 */
	async stopped() {

	}
};
